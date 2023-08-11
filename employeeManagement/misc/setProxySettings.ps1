$Utf8NoBomEncoding = New-Object System.Text.UTF8Encoding $False
function Test-ISIDProxyConnection() {
    Test-Connection proxy.isid.co.jp -Quiet
}


function Update-ProxySettings {
    Write-Host "Updating Proxy Settings..."
    if (!([Security.Principal.WindowsPrincipal][Security.Principal.WindowsIdentity]::GetCurrent()).IsInRole("Administrators")) { Start-Process powershell.exe "-File `"$PSCommandPath`"" -Verb RunAs; exit }
    $data = Get-Content ./gradle.properties
    $result = @()
    for ($counter = 0; $counter -lt $data.Length; ($counter++)) { 
        if (-Not(@($data)[$counter].StartsWith("systemProp.http"))) {
            $result += @($data)[$counter]
        }
    }
    if (Test-ISIDProxyConnection) {
        $result += "systemProp.http.proxyHost=proxy.isid.co.jp"
        $result += "systemProp.http.proxyPort=8080"
        $result += "systemProp.https.proxyHost=proxy.isid.co.jp"
        $result += "systemProp.https.proxyPort=8080"
        reg add "HKEY_CURRENT_USER\Environment" /v "HTTP_PROXY" /t REG_SZ /d "proxy.isid.co.jp:8080" /f
        reg add "HKEY_CURRENT_USER\Environment" /v "HTTPS_PROXY" /t REG_SZ /d "proxy.isid.co.jp:8080" /f
        reg add "HKEY_CURRENT_USER\Environment" /v "NO_PROXY" /t REG_SZ /d "127.0.0.1,localhost,*isid.co.jp,*dentsu.co.jp" /f
        reg add "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v "ProxyEnable" /t REG_DWORD /d "1" /f
        reg add "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v "ProxyServer" /t REG_SZ /d "proxy.isid.co.jp:8080" /f
        reg add "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v "ProxyOverride" /t REG_SZ /d "*.dentsu.co.jp;*.isid.co.jp" /f
        netsh winhttp import proxy source=ie
        git config --global http.proxy http://proxy.isid.co.jp:8080
        git config --global https.proxy http://proxy.isid.co.jp:8080
    }
    else {
        reg delete "HKEY_CURRENT_USER\Environment" /v "HTTP_PROXY" /f
        reg delete "HKEY_CURRENT_USER\Environment" /v "HTTPS_PROXY" /f
        reg delete "HKEY_CURRENT_USER\Environment" /v "NO_PROXY" /f
        reg delete "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v "ProxyEnable" /f
        reg delete "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v "ProxyOverride" /f
        reg delete "HKEY_CURRENT_USER\Software\Microsoft\Windows\CurrentVersion\Internet Settings" /v "ProxyServer" /f
        netsh winhttp reset proxy
        git config --global --unset http.proxy
        git config --global --unset https.proxy
    }

    [System.IO.File]::WriteAllLines("./gradle.properties", $result, $Utf8NoBomEncoding)
}

Update-ProxySettings

$Utf8NoBomEncoding = New-Object System.Text.UTF8Encoding $False
function updateGradleProperties() {
    param (
        $url,
        $userName,
        $rawPW
    )
    $data = Get-Content ./gradle.properties
    for ($counter = 0; $counter -lt @($data).Length; ($counter++)) { 
        if (-Not(@($data)[$counter].StartsWith("org.gradle.java.home"))) {
            $result += @($data)[$counter]
        }
    }
    $java = $env:JAVA_HOME
    $java = $java.Replace("\", "\\")
    $result += 'org.gradle.java.home=' + $java
    [System.IO.File]::WriteAllLines("./gradle.properties", $result, $Utf8NoBomEncoding)
}

updateGradleProperties

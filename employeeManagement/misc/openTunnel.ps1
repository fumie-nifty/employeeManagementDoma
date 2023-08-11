Param (
    [parameter(mandatory)][string]$SSHKeyPath,
    [parameter(mandatory)][string]$BastionIP,
    [parameter(mandatory)][string]$TargetAddress
)

function setSSHTunnel() {
    param (
        $SSHKeyPath,
        $BastionIP,
        $TargetAddress
    )
    ssh -o ProxyCommand='C:\Program Files\Git\mingw64\bin\connect.exe -H proxy.isid.co.jp:8080 %h %p' -i "$SSHKeyPath" -p 10022 -fNL 33060:"$TargetAddress":3306 ec2-user@"$BastionIP"
}

setSSHTunnel $SSHKeyPath $BastionIP $TargetAddress

$OutputEncoding = 'utf-8'

$Utf8NoBomEncoding = New-Object System.Text.UTF8Encoding $False

function generateUrl() {
  param(
    $hostname,
    $port,
    $DBName
  )
  return $hostname + ':' + $port + '/' + $DBName + '?serverTimezone=JST&useSSL=false&allowPublicKeyRetrieval=true&characterEncoding=UTF-8'
}

function setDBCredentials() {
  param(
    $url,
    $userName,
    $rawPW
  )
  $propertiesPath = "./gradle.properties"
  if (-not (Test-Path $propertiesPath)) {
    $null | Out-File -FilePath $propertiesPath -Encoding utf8
    Write-Host "gradle.properties ファイルが作成されました。"
  }
  $gradlePropertiesSource = Get-Content $propertiesPath
  $gradlePropertiesResult = @()
  for ($counter = 0; $counter -lt @($gradlePropertiesSource).Length; ($counter++)) {
    if (-Not(@($gradlePropertiesSource)[$counter].StartsWith("doma"))) {
      $gradlePropertiesResult += @($gradlePropertiesSource)[$counter]
    }
  }
  $envfile = @()
  $envfile += 'ADV_DB_URL=' + $url
  $envfile += 'ADV_DB_USERNAME=' + $userName
  $envfile += 'ADV_DB_PASSWORD=' + $rawPW
  $gradlePropertiesResult += 'domaUrl=jdbc:mysql://' + $url
  $gradlePropertiesResult += 'domaUser=' + $userName
  $gradlePropertiesResult += 'domaPassword=' + $rawPW
  [System.IO.File]::WriteAllLines("./gradle.properties", $gradlePropertiesResult, $Utf8NoBomEncoding)
  [System.IO.File]::WriteAllLines("./.env", $envfile, $Utf8NoBomEncoding)
}

Write-Host "Doma/Spring BootのDB接続設定を更新します。"

$dHost = "localhost"
$dport = "3306"
$dDBName = 'adv'
$duserName = 'root'
$PW = ''
$hostname = Read-Host "MySQLサーバーのホスト名を入力してください [${dHost}]"
$port = Read-Host "MySQLサーバーのポート番号を入力してください [${dport}]"
$DBName = Read-Host "MySQLサーバーのデータベース名を入力してください [${dDBName}]"
$userName = Read-Host "MySQLサーバーのユーザー名を入力してください [${duserName}]"

while (($PW -eq '') -or ([System.Runtime.InteropServices.Marshal]::PtrToStringBSTR([System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($PW)) -eq '')) {
  $PW = Read-Host "MySQLサーバーのユーザー: ${duserName} のパスワードを入力してください" -AsSecureString
}

if (($hostname -eq '') -or ($null -eq $hostname)) { $hostname = $dHost }
if (($port -eq '') -or ($null -eq $port)) { $port = $dport }
if (($DBName -eq '') -or ($null -eq $DBName)) { $DBName = $dDBName }
if (($userName -eq '') -or ($null -eq $userName)) { $userName = $duserName }

$url = generateUrl $hostname $port $DBName
$rawPW = [System.Runtime.InteropServices.Marshal]::PtrToStringBSTR([System.Runtime.InteropServices.Marshal]::SecureStringToBSTR($PW))
setDBCredentials $url $userName $rawPW

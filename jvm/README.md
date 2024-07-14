# myinvois-open-sdk

Open Java SDK for MyInvois API

## Running Test Main

```bash
> export MYINVOIS_CLIENT_ID=<your-client-id>
> export MYINVOIS_CLIENT_SECRET=<your-client-secret>
> export MYINVOIS_TIN=<your-tin>
> export MYINVOIS_ID_TYPE=<your-id-type>
> export MYINVOIS_ID_VALUE=<your-id-value>
> export MYINVOIS_JKS_FILE_PATH=<your-jks-file-path>
> export MYINVOIS_JKS_STORE_PASSWORD=<your-jks-store-password>
> export MYINVOIS_JKS_ALIAS_NAME=<your-jks-alias-name>
> export MYINVOIS_JKS_ALIAS_PASSWORD=<your-jks-alias-password>
> export MYINVOIS_CERT_FILE_PATH=<your-certificate-file-path>
> mvn compile
> mvn exec:java -D"exec.mainClass"="com.amaseng.myinvois.TestMain"
```
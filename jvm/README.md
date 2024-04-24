# myinvois-open-sdk

Open Java SDK for MyInvois API

## Running Test Main

```bash
> export MYINVOIS_CLIENT_ID=<your-client-id>
> export MYINVOIS_CLIENT_SECRET=<your-client-secret>
> export MYINVOIS_TIN=<your-tin>
> export MYINVOIS_ID_TYPE=<your-id-type>
> export MYINVOIS_ID_VALUE=<your-id-value>
> mvn compile
> mvn exec:java -D"exec.mainClass"="com.amaseng.myinvois.TestMain"
```
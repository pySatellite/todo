# springboot todo by myb...

## RUN
```
$ ./gradlew clean bootJar
$ docker compose up -d --force-recreate --build
```

## Check Telnet
```
$ docker exec -it todo-container sh
$ / # cat /etc/os-release
NAME="Alpine Linux"
ID=alpine
VERSION_ID=3.14.0
PRETTY_NAME="Alpine Linux v3.14"
HOME_URL="https://alpinelinux.org/"
BUG_REPORT_URL="https://bugs.alpinelinux.org/"
/ # apk add busybox-extras
fetch https://dl-cdn.alpinelinux.org/alpine/v3.14/main/x86_64/APKINDEX.tar.gz
fetch https://dl-cdn.alpinelinux.org/alpine/v3.14/community/x86_64/APKINDEX.tar.gz
(1/1) Installing busybox-extras (1.33.1-r8)
Executing busybox-extras-1.33.1-r8.post-install
Executing busybox-1.33.1-r2.trigger
OK: 8 MiB in 21 packages
/ # busybox-extras telnet localhost 3306
telnet: can't connect to remote host (127.0.0.1): Connection refused
/ # busybox-extras telnet database 3306
Connected to database
i
11.3.2-MariaDB-1:11.3.2+maria~ubu22044HO2J`%2��-lMx9N_r>~#0gmysql_native_passwordConnection closed by foreign host
```

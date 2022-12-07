








## Exportar todas as informações do keycloak

```
docker exec -it kat_keycloak /opt/jboss/keycloak/bin/standalone.sh -Djboss.socket.binding.port-offset=100 -Dkeycloak.migration.action=export -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.realmName=project_realm -Dkeycloak.migration.usersExportStrategy=REALM_FILE -Dkeycloak.migration.file=/tmp/export.json

# copiar arquivo para o host
docker cp kat_keycloak:/tmp/export.json /home/wall-e/Downloads
```

## Pegar o `access_token`

Precisamos disso para que o token tenha o mesmo `issuer`. Conseguimos autenticar do host, porém quando chamar o serviço que vai chamar o keycloak para atorizar vai dar erro falando que o issuer está incorreto, isso é pq a URL do keycloak que o host e o container usam são de fato diferentes.

Coloquei uma "codegueira" no final do comando para "printar" apenas o token.

```
(docker exec -it kat_keycloak sh -c "curl --location --request POST 'http://keycloak:8080/auth/realms/project_realm/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'client_id=api-client-authenticator' \
--data-urlencode 'username=teste' \
--data-urlencode 'password=123' \
--data-urlencode 'grant_type=password'") | grep -Po '"access_token":.*?[^\\]"' | awk -F':' '{print $2}' | sed 's/^.//;s/.$//'
```


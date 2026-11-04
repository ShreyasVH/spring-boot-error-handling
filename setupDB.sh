usql "postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@$POSTGRES_IP:$POSTGRES_PORT/postgres" -c "CREATE DATABASE $POSTGRES_DB;" > /dev/null 2>&1

usql "postgres://$POSTGRES_USER:$POSTGRES_PASSWORD@$POSTGRES_IP:$POSTGRES_PORT/$POSTGRES_DB" -f src/main/resources/db.sql > /dev/null 2>&1
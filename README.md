# demo_farmatodo

Para correr la api Rest, utilice en Linux: ./mvnw spring-boot:run

1. Endpoint: /episode/{id} se utiliza para consultar un episodio de RickAndMorty, method Get de http. Ejemplo: id:28
2. El modelo entidad-relación queda en src/main/resources/static/img y el script para crear la b.d en src/main/resources/static/sql/create_db
   Las tablas se crean por el código utilizando las anotaciones de jpa.
3. Pendiente el número feliz
4. Endpoint:sum/{number} se utiliza para consultar la sumatoria de un número natural. Ejemplo: number: 10
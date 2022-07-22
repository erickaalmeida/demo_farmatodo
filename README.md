# demo_farmatodo

Para correr la api Rest, utilice en Linux: ./mvnw spring-boot:run

1. Endpoint: /episode/{id} se utiliza para consultar un episodio de RickAndMorty, method Get de http. Ejemplo: id:28
2. El modelo entidad-relación queda en src/main/resources/static/img y el script para crear la b.d en src/main/resources/static/sql/create_db
   Las tablas se crean por el código utilizando las anotaciones de jpa.
3. El endpoint para número feliz es /happy-numbers, method post, recibe Json de la siguiente forma: 
```json{
   "numbers": [1, 2, 3, 203, 5, 7]
   }
   ```
4. Endpoint:sum/{number} se utiliza para consultar la sumatoria de un número natural. Ejemplo: number: 10
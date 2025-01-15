# Creación de microservicio para productos

Realizar un microservicio usando Spring Boot que registre un producto con los atributos id, descripción, precio y stock y otro que consulte el producto registrado.


# Dependencias:

1. Spring Web
2. Spring Data JPA
3. MySQL Driver
4. Spring Security
5. JSON Web Token (JWT)
6. Spring Doc
7. JUnit
8. Mockito

## Estructura

controller:
- ProductController: Aqui se crearon los endpoints para guardar y consultar un producto.
  dto:
- ProductDTO: Se declaro solo las variables de producto que se pueden agregar cuando se crea un nuevo producto, se utilizo como un RequestBody en el metodo save.
  entity:
- Product: Es la entidad que representa a la tabla en la base de datos llamada products.
  exceptions:
- GlobalExceptionHandler: Se definen las excepciones globales que pueden ser usadas en toda la aplicacion.
- ProductNotFoundException: Excepcion personalizada cuando no se encuentra un determinado producto.
  repository:
- ProductRepository: Interfaz que tiene los metodos para conectarse a la base de datos MySQL mediante JPA e Hibernate.
  security:
- CorsConfig: Clase donde se establecen las medidas de seguridad para las solicitudes HTTP.
- SecurityConfig: Clase que llama a los métodos de Spring Security definiendo reglas de autorización para proteger endpoints específicos. (**IMPORTANTE: Esta clase fue comentada porque no permitía ejecutar ningún endpoint desde el swagger debido a que solicitaba una autorización**)
- Token JWT: Clase que llama a los metodos de JSON Web Token proporcionando un token firmado para la autenticacion de un usuario.
  service:
- ProductService: Interfaz donde se declaran los metodos de la clase ProductServiceImpl
  impl:
    - ProductServiceImpl: Se declaran los métodos de la lógica de negocio.

## Testing (Pruebas unitarias)

Se utilizo las librerías JUnit y Mockito.
Las pruebas unitarias se encuentran en la ruta:

src/test/java/com/example/codechallenge/controller

- ProductControllerTest: Clase donde se encuentran los test, en este caso se crearon 2 test para el controller getProductById
    - testGetProductById_Success: Test para saber si el proceso se completó satisfactoriamente y el producto consultado se encuentra registrado en la base de datos.
    - testGetProductById_NotFound: Test para saber si el producto consultado no se encuentra registrado en la base de datos.
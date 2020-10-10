# prueba-java
Pasos para la instalación:
1. Descargar las fuentes.
2. Importarlas al IDE (Eclipse / Spring Tool Suite)
3. Copiar el archivo usuarios.txt que se encuentra en la carpeta "data" de las fuentes, en el disco C.
4. Levantar el servidor de springboot (Click derecho a la clase SpringBootDemoApplication / Run As / Java Application)
5. Colocar la URL http://localhost:8085/login desde Postman (si no se tiene, descargar previamente).
6. Seleccionar tipo POST y agregar el siguiente json en el Body:

{
	"username": "user",
	"password": "password"
}

Nota: El username puede variar dependiendo del contenido del archivo usuarios.txt. El password debe ser el mismo.

7. Ejecutar y obtener copiar la respuesta del atributo token.
8. En otra ventana, colocar la URL http://localhost:8085/saludarCliente
9. Entrar a la pestaña Headers y agregar en el campo Key el valor "Authorization". Luego en el campo value la palabra "Bearer", dar un espacio y copiar la respuesta que se obtuvo en el atributo token.
10. Ejecutar y se obtendrá la respuesta.

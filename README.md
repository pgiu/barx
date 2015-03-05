# barx
**barx** (**b**ancos **ar**gentinos e**x**porter) es un exportador de información del estado de cuenta de Banco Galicia a CSV/QIF para usar en GnuCash, MoneyManagerEx, etc.

# Objetivo y motivación
**barx** es un parser para la información que da el Banco Galicia en su servicio de Home Banking.
La intención es escribir un código que pueda ser capaz de: 
- conectarse a la página del banco
- parsear el documento (ya sea leyendo el código HTML o bien tomando la opción *exportar a XLS*
- exportar en formatos QIF y CSV compatibles con MoneyManagerEx y otros. 

Soy cliente del Banco Galicia y no encontré forma de *sacar* los datos (que son mios) en un formato accesible para cualquier programa de gestión de finanzas. 
Por eso decidí iniciar este pequeño programa con el cual satisfacer mi necesidad. 

# Build
Para hacer el build desde netbeans o bien por linea de comando. Debería generarse el directorio dist/ con el .jar correcto junto con las librerias externas.

# Uso 
Por ahora funciona de la siguiente manera: 
- Entrar en https://wsec01.bancogalicia.com.ar/scripts/homebanking/GalHBlogin.asp con su número de DNI y contraseña
- Ir a la página del resumen 
- Guardar la página a un archivo. 
- Buscar en la carpeta donde se guardó el archivo resumen.htm (contiene la información relevante) y copiarlo a la carpeta dist de este proyecto.
- Hacer 
	java -jar GaliciaReader.jar resumen.htm outputName categorias_gastos.csv
(*nota I* para ver una descripción de los parámetros ver sección parámetros.
(*nota II* puede que haya errores o warnings, ignorarlos)
- Importar output.qif en GnuCash (también puede usarse la salida CSV, pero tiene mas errores).

# Parámetros
GaliciaReader.jar resumen.htm outputName categorias_gastos.csv

- *resumen.htm* es el resumen tal y como sale de la página del banco. 
- *outputName* es el nombre del archivo de salida (sin la  terminación .csv ni .qif) 
- *categorias_gastos.csv* es un archivo csv de dos columnas donde la columna de la izquierda es una expresión regular y la de la derecha es el nombre de la cuenta que se usa en GnuCash. 

Ejemplo de categorias_gastos.csv
```
GOETHE INSTITUT;Education
INTERES CAPITALIZADO;Income:Interest Income:Savings Interest
ATALAYA;Expenses:Dining
HIPER CHASCOMUS SRL;Expenses:Groceries
```

# Disclaimer
Bajo ningún punto estoy afiliado o tengo intereses con el Banco Galicia. Este programa se distribuye bajo licencia GNU GPL V2. 
Siéntase libre de modificarlo a gusto siempre que cite este desarrollo como original. 

# Dependencias y librerías externas
Este programa usa: 
- **jsoup** (http://jsoup.org) para el parseo
- **jfreechart** (http://jfree.org) para los graficos

# To Do list
Esta no es una lista exhaustiva pero es un recordatorio de lo que sería interesante que este software pudiera hacer.
- detección de cobro de sueldo. Debería poder unirse las categorías como SAC, Bonos, Sueldo bajo un mismo paraguas para poder identificar cuanto se cobró de un mismo empleador. 

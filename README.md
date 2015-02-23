# barx
**barx** (**b**ancos **ar**gentinos e**x**porter) es un exportador de información del estado de cuenta de Banco Galicia a CSV/QIF para usar en MoneyManagerEx, GnuCash, etc.

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
	java -jar GaliciaReader.jar Resumen2015.htm  output.csv
(*nota* puede que haya errores o warnings, ignorarlos)
- Importar output.csv en MoneyManagerEx usando la opción Formato MMEX y fecha en formato DD-MM-YYYY



# Disclaimer
Bajo ningún punto estoy afiliado o tengo intereses con el Banco Galicia. Este programa se distribuye bajo licencia GNU. 
Siéntase libre de modificarlo a gusto siempre que cite este desarrollo como original. 

# Dependencias y librerías externas
Este programa usa: 
- **jsoup** (http://jsoup.org) para el parseo
- **jfreechart** (http://jfree.org) para los graficos

# To Do list
Esta no es una lista exhaustiva pero es un recordatorio de lo que sería interesante que este software pudiera hacer.
- clasificación automática por categoría y subcategoria. Debería poder buscar regexps en el campo *movimiento* de la página del banco y mapearlo a un conjunto de categorías. Así se podría saber cuanto se consumo en un mismo local, o bien en un mismo rubro. 
- detección de cobro de sueldo. Debería poder unirse las categorías como SAC, Bonos, Sueldo bajo un mismo paraguas para poder identificar cuanto se cobró de un mismo empleador. 
- unificación de los intereses ganados / descuentos / etc.
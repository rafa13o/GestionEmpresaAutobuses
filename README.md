# GestionEmpresaAutobuses
Programa que gestiona una empresa dedicada al transporte de pasajeros por carretera


****************************************************************************************
Se requiere hacer una aplicación que gestione, a través de una ventana, los
siguientes aspectos de una empresa de autobuses privada con sus restricciones
pertinentes.
  + Trabajadores:
    Un trabajador se definirá por el DNI, su nombre, sus dos apellidos, la
sección en la que trabaja y el año de ingreso a la empresa.
    Restricciones:
      - DNI: El DNI estará formado por 8 números y una letra.
      - Año de ingreso: El año de ingreso no será superior al actual.
      - Secciones: Mantenimiento, conductores, dirección.
      - No puede haber dos trabajadores con el mismo DNI.
  + Autobuses
    Un autobús estará definido por su matrícula, el fabricante de la
carrocería, el modelo, el fabricante del motor, el número de plazas, el precio de compra y su
tipo de combustible.
    Restricciones:
      - Matrícula: La matrícula es única para cada autobús.
      - Plazas: No podrá exceder de 70 ni ser menor de 10.
      - Precio: No podrá ser inferior de 20.000€.
      - Combustible: Gasolina, diésel, híbrido o eléctrico.
      - Podrán existir varios autobuses del mismo modelo con las
mismas características, es decir, no hay que controlar que solo haya un modelo de cada
autobús.
      - El fabricante y el modelo no se guardarán conjuntamente.
            (Por ejemplo:
                  Fabricante carrocería: Irizar
                  Modelo: i6s)
  + Rutas
    Las rutas estarán definidas por un código de ruta, la ciudad de inicio,
la ciudad de fin, los kilómetros recorridos, el conductor que realizará la ruta, el autobús que
se utilizará y el cliente que lo ha solicitado.
    Restricciones:
      - Código: Estará definido por las iniciales de las ciudades de
salida y de llegada y los kilómetros entre ambas. A su vez, tendrá 2 letras y 5 números.
(Valladolid - Madrid => VM00189). El código no será único ya que podrán existir varias rutas
con distintos autobuses. Se considerará que una ruta es distinta a otra si alguna de sus
características cambia.
      - Fecha: la fecha no podrá ser inferior a la actual.
      - Conductor: El conductor será un DNI previamente registrado.
      - Autobús: El autobús será una matrícula registrada.
      - Cliente: El cliente será el nombre de uno ya registrado.
  + Clientes
    Los clientes estarán definidos por un código de cliente, el nombre, la
localidad y el teléfono de contacto.
    Restricciones:
      - Código: Estará formado por las 3 primeras letras de su
nombre y 3 dígitos numéricos aleatorios. El código lo debe generar el propio programa, y no
deberá repetirse.
      - Teléfono: El teléfono tendrá una extensión de 9 dígitos.
  + Facturas
    Las facturas se definirán mediante un número de factura, el nombre
del cliente, la localidad del cliente, el teléfono del cliente, la ruta solicitada, la fecha de la
factura y el precio del servicio.
    Restricciones:
      - Número de factura: Generado por el programa.
      - Cliente: Registrado previamente en el programa.
      - Ruta: Registrada previamente en el programa.
      - Precio: 0’20€ por kilómetro recorrido.
      
  + Restricciones generales del programa:
      - Todos los datos se almacenarán en archivos.
      - Los datos deberán poderse visualizar en tablas.
      - Los datos de los autobuses deberán poderse filtrar por fabricante de la
carrocería.
      - Los trabajadores podrán ordenarse por número de DNI o por año de ingreso
en la empresa.
      - Los datos de trabajadores y autobuses se deberán poder dar de baja
(seleccionándolos en la tabla y eliminándolos del archivo).

# Description: Programa que calcula el factorial de un número
resultado = 1;
num=int(input("Ingrese un número: "))
contador = 2;
while contador <= num:
    resultado *= contador;
    contador += 1;
print("El factorial de", num, "es", resultado)
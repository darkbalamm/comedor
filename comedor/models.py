from django.db import models

# Create your models here.
class asuario(models.Model):
    nombre=models.CharField(max_length=50)
    contraseña=models.CharField(max_length=16)
    correo=models.EmailField()
    def __str__(self):
        return self.nombre
class Horario(models.Model):
    nombre=models.CharField(max_length=30)
    horario_inicial=models.TimeField()
    horario_final=models.TimeField()
    def __str__(self):
        return self.nombre
class Platillo(models.Model):
    nombre= models.CharField(max_length=30)
    tipo=models.ForeignKey(Horario,on_delete= models.CASCADE )
    def __str__(self):
        return self.nombre
class menu(models.Model):
    nombre=models.CharField(max_length=30)
    Platillo=models.ForeignKey(Platillo, on_delete=models.CASCADE)
    Horario=models.DateField()
    def __str__(self):
        return self.nombre
    

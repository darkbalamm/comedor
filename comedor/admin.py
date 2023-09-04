from django.contrib import admin

from .models import asuario,Horario,Platillo,menu

# Register your models here.
class asuarigestion(admin.ModelAdmin):
    list_display=("id","nombre","contraseña","correo")
admin.site.register(asuario,asuarigestion)

class horariogestion(admin.ModelAdmin):
    list_display=("id","nombre","horario_inicial","horario_final")
admin.site.register(Horario,horariogestion)

class platillogestion(admin.ModelAdmin):
    list_display=("id","nombre","tipo")
admin.site.register(Platillo,platillogestion)

class menugestion(admin.ModelAdmin):
    list_display=("id","nombre","Platillo","Horario")
admin.site.register(menu,menugestion)

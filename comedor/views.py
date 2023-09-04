from django.shortcuts import render, HttpResponse

from .models import asuario,Horario,menu,Platillo

# Create your views here.
def saludo(request):
    pla=Platillo.objects.all()
    hor=Horario.objects.all()
    return render(request, "comedor/index.html",{"platillo":pla,"hors":hor})

def Menu(request):
    men=menu.objects.all()
    pla=Platillo.objects.all()
    return render(request,"comedor/menu.html",{"menu":men,"platillo":pla})
def horarios(request):
    horarios=Horario.objects.all()
    return render(request,"comedor/horarios.html",{"horarios": horarios})
def trabajador(request):
    return render(request,"comedor/trabajador.html")
def login(request):
    usuario=asuario.objects.all()
    for a in usuario:
        print(a)
    return render(request,"comedor/login.html",{"usuario": usuario})
def gestor(request):

    return render(request,"comedor/gestor.html")
def gestor_menu(request):
    return render(request,"comedor/gestor_menu.html")
def gestor_horarios(request):

    return render(request,"comedor/gestor_horarios.html")
def gestor_platillo(request):

    return render(request,"comedor/gestor_platillo.html")

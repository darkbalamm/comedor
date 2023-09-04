from django.urls import path

from comedor import views
urlpatterns = [
    path('comedor/',views.saludo, name="comedor"),
    path('menu/', views.Menu, name="menu"),
    path("horarios/",views.horarios, name="horarios"),
    path('trabajador/',views.trabajador, name="trabajador"),
    path('login/',views.login, name="login"),
    path('gestor/',views.gestor,name="gestor"),
    path('gestor_menu/',views.gestor_menu, name="gestor_menu"),
    path('gestor_horario/',views.gestor_horarios,name="gestor_horario"),
    path('gestor_platillo/',views.gestor_platillo,name="gesttor_platillo"),
]

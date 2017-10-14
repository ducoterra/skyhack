from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.search, name = 'search'),
    url(r'^courselist/$', views.courseProgress, name = 'courselist')
]

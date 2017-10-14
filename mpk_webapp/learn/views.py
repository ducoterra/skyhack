from django.shortcuts import render
from .flightaware import *

def search(request):
    '''
    returns the search screen for users to enter their flight info
    '''
    siteDict = {}
    siteDict = checkRequest(request, siteDict)
    return render(request, 'learn/search.html', siteDict)

def chooseTopic(request, siteDict):
    '''
    returns a list of topics for the user to choose from
    '''
    return render(request, 'learn/topics.html', siteDict)

def chooseCourse(request, siteDict):
    '''
    returns the list of available courses for the user to take based on their
    selection
    '''
    return render(request, 'learn/courses.html', siteDict)

def courseProgress(request):
    '''
    returns the user's in proress courses and completed courses in a list
    '''
    siteDict = {}
    return render(request, 'learn/progress.html', siteDict)

def checkRequest(request, siteDict):
    '''
    checks the request for POST messages

    Returns a string message to be sent back to the site
    for more info.
    '''
    if request.method == 'POST':
        if 'search_flight' in request.POST:
            depart_id = request.POST['depart_id'].strip().upper()
            arrive_id = request.POST['arrive_id'].strip().upper()
            time = getFlightInfo(startId = depart_id, endId = arrive_id)
            siteDict.update({'flight_time' : time})
            chooseCourse(request, siteDict)

    return siteDict

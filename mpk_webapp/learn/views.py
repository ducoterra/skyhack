from django.shortcuts import render
from .flightaware import *

def search(request):
    '''
    returns the search screen for users to enter their flight info
    '''
    siteDict = {'redirect' : None}
    siteDict = checkRequest(request, siteDict)

    if siteDict['redirect'] == 'topics':
        return render(request, 'learn/topics.html', siteDict)
    elif siteDict['redirect'] == 'courses':
        return render(request, 'learn/courses.html', siteDict)
    else:
        return render(request, 'learn/search.html', siteDict)

def courseProgress(request):
    '''
    returns the user's in proress courses and completed courses in a list
    '''
    siteDict = {}
    siteDict = checkRequest(request, siteDict)
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
            siteDict.update({'redirect' : 'topics'})
    return siteDict

from django.shortcuts import render
from .flightaware import *
from .khan import *

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
            flighttime = getFlightInfo(startId = depart_id, endId = arrive_id)
            siteDict.update({'flight_time' : time})
            hours = str(flighttime // 60)
            minutes = flighttime % 60
            if minutes < 10:
                minutes = str(minutes) + '0'
            else:
                minutes = str(minutes)
            strTime = hours + ":" + minutes
            siteDict.update({'str_time' : strTime})
            siteDict.update({'topic_list' : getTopics()})
            siteDict.update({'redirect' : 'topics'})

        if 'search_course' in request.POST:
            selection = request.POST['search_course']
            print(selection)
            videoList = getVideoSelection(subject = selection)
            siteDict.update({'video_list' : videoList})
            siteDict.update({'redirect' : 'courses'})
    return siteDict

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
    elif siteDict['redirect'] == 'progress':
        return render(request, 'learn/progress.html', siteDict)
    else:
        return render(request, 'learn/search.html', siteDict)

def checkRequest(request, siteDict):
    '''
    checks the request for POST messages

    Returns a string message to be sent back to the site
    for more info.
    '''
    if request.method == 'POST':

        if 'search_flight' in request.POST:
            try:
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
            except:
                siteDict.update({'failure' : 'departure or arrival not valid'})

        if 'search_course' in request.POST:
            print(request.POST)
            selection = request.POST['search_course']
            videoList = getSubSelection(subject = selection)
            siteDict.update({'str_time' : request.POST['str_time']})
            siteDict.update({'video_list' : videoList})
            siteDict.update({'redirect' : 'courses'})

        if 'done' in request.POST:
            print(request.POST)
            selections = []
            for key in request.POST:
                if key.startswith('selections'):
                    selections.append(request.POST[key])
            courseOptions = []
            for selection in selections:
                courseOptions += drillDown(selection)
            siteDict.update({'video_list' : courseOptions})
            siteDict.update({'str_time' : request.POST['str_time']})
            siteDict.update({'redirect' : 'progress'})
    return siteDict

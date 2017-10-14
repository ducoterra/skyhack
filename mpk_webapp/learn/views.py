from django.shortcuts import render

def search(request):
    '''
    returns the search screen for users to enter their flight info
    '''
    siteDict = {'course' : 'this is a test'}
    siteDict = checkRequest(request, siteDict)
    return render(request, 'learn/search.html', siteDict)

def chooseTopic(request):
    '''
    returns a list of topics for the user to choose from
    '''
    siteDict = {}
    return render(request, 'learn/topics.html', siteDict)

def chooseCourse(request):
    '''
    returns the list of available courses for the user to take based on their
    selection
    '''
    siteDict = {}
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
            depart_id = request.POST['depart_id'].strip()
            siteDict.update({'depart_id' : depart_id})
    return siteDict

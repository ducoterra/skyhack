from django.shortcuts import render

def search(request):
    '''
    returns the search screen for users to enter their flight info
    '''
    return render(request, 'learn/search.html', siteDict)

def chooseTopic(request):
    '''
    returns a list of topics for the user to choose from
    '''
    return render(request, 'learn/topics.html', siteDict)

def chooseCourse(request):
    '''
    returns the list of available courses for the user to take based on their
    selection
    '''
    return render(request, 'learn/courses.html', siteDict)

def courseProgress(request):
    '''
    returns the user's in proress courses and completed courses in a list
    '''
    return render(request, 'learn/progress.html', siteDict)

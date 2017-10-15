'''
Author: Reese Wells
Copyright 2017

Contains the methods for dealing with khan academy api data
'''
import requests, json, random

def getTopics():
    return ['math', 'science', 'economics-finance-domain',
    'humanities', 'computing', 'test-prep', 'educator-test',
    'partner-content', 'talks-and-interviews', 'college-careers-more',
    'talent-search', 'resources', 'mappers']

def getSubSelection(subject = None):
    '''
    takes a string subject
    returns the list of sub subjects
    '''
    r = requests.get('http://www.khanacademy.org/api/v1/topic/' + subject)
    data = r.json()
    courseList = []

    for sub in data['children']:
        courseList.append(sub['node_slug'])

    return courseList

def getVideos(subject = None):
    '''
    takes a string subject
    returns the videos associated with that subject
    '''
    r = requests.get('http://www.khanacademy.org/api/v1/topic/'
                        + subject + '/videos')
    try:
        data = r.json()
        courseList = []

        for video in data:
            courseList.append(video['translated_title'] + ',' + str(video['duration']))
        return courseList
    except:
        return None

def drillDown(subject = None):
    '''
    finds videos about a subject
    '''
    videos = getVideos(subject)
    if videos is not None and len(videos) != 0:
        return videos
    children = getSubSelection(subject)
    numChilds = len(children)
    selection = random.randint(0, numChilds - 1)
    return drillDown(children[selection])

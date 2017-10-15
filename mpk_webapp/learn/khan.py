'''
Author: Reese Wells
Copyright 2017

Contains the methods for dealing with khan academy api data
'''
import requests, json

def getTopics():
    return ['math', 'science', 'economics-finance-domain',
    'humanities', 'computing', 'test-prep', 'educator-test',
    'partner-content', 'talks-and-interviews', 'college-careers-more',
    'talent-search', 'resources', 'mappers']

def getVideoSelection(subject = None):
    '''
    takes a string subject
    subject is one of the following:
        1 math
        2 science
        3 economics-finance-domain
        4 humanities
        5 computing
        6 test-prep
        7 educator-test
        8 partner-content
        9 talks-and-interviews
        10 college-careers-more
        11 talent-search
        12 resources
        13 mappers
    returns a list of video titles and descriptions that relate
    '''
    subjList = {'math': 0, 'science': 1, 'economics-finance-domain': 2,
    'humanities': 3, 'computing': 4, 'test-prep': 5, 'educator-test': 6,
    'partner-content': 7, 'talks-and-interviews': 8, 'college-careers-more': 9,
    'talent-search': 10, 'resources': 11, 'mappers': 12}

    try:
        f = open('khan.tree', 'r')
        data = json.load(f)
        # print('opened file')
    except:
        f = open('khan.tree', 'w')
        r = requests.get('http://www.khanacademy.org/api/v1/topictree')
        data = json.loads(r.text)
        json.dump(data, f)
        # print('file not found')

    courseList = []

    for sub1 in data['children'][subjList[subject]]['children']:
        for sub2 in sub1['children']:
            for sub3 in sub2['children']:
                video = json.loads(requests.get('http://www.khanacademy.org/api/v1/topic/' +\
                    sub3['slug'] + '/videos').text)
                try:
                    courseList.append(video[0]['translated_title'] + ", " + str(video[0]['duration']))
                    # print(courseList)
                except:
                    print('')
                if len(courseList) == 10:
                    return courseList

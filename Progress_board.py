# Problem description
# Copyright: Gordon Zhu and Lily Gentner from WatchAndCode.com
# The problem description was originally in JavaScript.
# Strategy and solution by me.

# Part 1
# Given a string (`student`) and an array of grade objects (`grades`), return an array containing all of that student's grades.

# Example: grades = [
#     {'student': 'a', 'grade': 90},
#     {'student': 'b', 'grade': 80},
#     {'student': 'a', 'grade': 95},
# ]

# getStudentGrades('a', grades) # should return [90, 95]
# getStudentGrades('b', grades) # should return [80]

################################

# Part 2

# Given an array of students (`students`) and an array of grade objects (`grades`), return an array of objects, each representing a student and all of their grades.

# Your result must maintain the same student order as `students`. 

# Example: grades = [
#     {'student': 'a', 'grade': 90},
#     {'student': 'b', 'grade': 80},
#     {'student': 'a', 'grade': 95},
# ]

# getAllStudentGrades(['a', 'b'], grades)
# should return [{'student': 'a', 'grades': [90, 95]}, {'student': 'b', 'grades': [80]}]

# getAllStudentGrades(['b', 'a'], grades)
# should return [{'student': 'b', 'grades': [80]}, {'student': 'a', 'grades': [90, 95]}]

################################

# STRATEGY PART 1

# grades = []

# For each grade_object in grades:
#   If grade_object['student'] is 'a':
#       Add grade_object['grade'] to grades

# Return grades

from typing import List, Dict, Any

all_grades = [
    {'student': 'a', 'grade': 90},
    {'student': 'b', 'grade': 80},
    {'student': 'a', 'grade': 95},
]

def get_student_grades(student, all_grades) -> List[int]:
    grades = []

    for grade_object in all_grades:
        if grade_object['student'] == student:
            grades.append(grade_object['grade']) # What is a way of doing this without a list method?

    return grades


# Time complexity: O(n) where n is all_grades.length
# Space complexity: O(n) where n is all_grades.length

################################

# PART 2, STRATEGY 1

#  Summary: For each student in `students`, collect all grades in `all_grades`.


all_grades = [
    {'student': 'a', 'grade': 90},
    {'student': 'b', 'grade': 80},
    {'student': 'a', 'grade': 95},
]

def get_all_student_grades(students, all_grades) -> List[Dict[str, List[int]]]:
    all_student_grades = []
    student_obj = None

    for student in students: 
        student_obj_created = False

        for grade in all_grades: 
            if grade['student'] == student:
                if student_obj_created == False:
                    student_obj = {
                        'student': student, 
                        'grades': [grade['grade']]
                    }
                    student_obj_created = True
                elif student_obj_created:
                    student_obj['grades'].append(grade['grade'])

        all_student_grades.append(student_obj)

    return all_student_grades

# Time complexity: O(n^2)

#  Space complexity: O(n)
# #################################

# PART 2, STRATEGY 2

# grades_map = {}
# Create a map of students to their grades:
# For each grade_object in all_grades:
    # If grade_object.student is not a key in grades_map:
        # grades_map[grade_object.student] = grade_object['grade']
    # Else if grade_object.student is a key in grades_map:
        # grades_map[grade_object.student].push(grade_object.grade)

# all_student_grades = []
# For each student in `students`:
    # all_student_grades.push({
    #   student: student,
    #   grades: grades_map[student]
    # })

# Return all_student_grades

# Time complexity: O(all_grades.length + students.length) = O(n)
# Space complexity: O(all_grades.length + number of grades in all_grades + students.length) = O(n0)

def get_all_student_grades_v2(students, all_grades) -> List[Dict[str, List[int]]]: 
    grades_map = {}

    for grade_object in all_grades:
        if grade_object['student'] not in grades_map:
            grades_map[grade_object['student']] = [grade_object['grade']]
        elif grade_object['student'] in grades_map:
            grades_map[grade_object['student']].append(grade_object['grade'])

    all_student_grades = []
    for student in students:
        all_student_grades.append({
            'student': student,
            'grades': grades_map[student]
        })

    return all_student_grades


# TRACE
# all_grades = [
#     {'student': 'a', 'grade': 90},
#     {'student': 'b', 'grade': 80},
#     {'student': 'a', 'grade': 95},
#       *
# ]
# students = [b, a]
#                *

# grades_map = {
#       'a': [90, 95],
#       'b': [80],
# }
# 
# all_student_grades = [{'student': 'b', grades: [80]}, {student: 'a', 'grades': [90, 95]} ]
# 









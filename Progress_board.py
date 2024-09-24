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

all_grades = [
    {'student': 'a', 'grade': 90},
    {'student': 'b', 'grade': 80},
    {'student': 'a', 'grade': 95},
]

def get_student_grades(student, all_grades):
    grades = []

    for grade_object in all_grades:
        if grade_object['student'] == student:
            grades.append(grade_object['grade']) # What is a way of doing this without a list method?

    return grades

print(get_student_grades('a', all_grades))

################################

# STRATEGY PART 2

# collected_grades = []

# For each grade_object in grades:
#   student_name = grade_object['student'] 
#   foud_student = False

#   For each element in collected_grades:
#       If element['student'] === student_name:
#           found_student = True
#           element['grades'].append(grade_object['grade'])
#   
#   If found_student == False:
#       collected_grades.append({
#           'student': student_name,
#           'grades': [grade_object['grade']]
#       }) 
#       
#   Return collected_grades




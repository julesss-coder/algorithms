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

# all_grades = [
#     {'student': 'a', 'grade': 90},
#     {'student': 'b', 'grade': 80},
#     {'student': 'a', 'grade': 95},
# ]

# def get_student_grades(student, all_grades):
#     grades = []

#     for grade_object in all_grades:
#         if grade_object['student'] == student:
#             grades.append(grade_object['grade']) # What is a way of doing this without a list method?

#     return grades

# print(get_student_grades('a', all_grades))

################################

# PART 2, STRATEGY 1 => INCORRECT. Does not take into account order of students in argument `students`.

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


# Summary: 
# def getAllStudentGrades(students, all_grades):
#     collected_grades = []

#     for grade in all_grades:
#         student_name = grade['student']
#         found_student = False

#         # Search for current student in results so far
#         for element in collected_grades:
#             # If student in results so far, add grade
#             if element['student'] == student_name:
#                 found_student = True
#                 element['grades'].append(grade['grade'])

#         # If stundent not in results so far, add new student entry
#         if found_student == False:
#             collected_grades.append({
#                 'student': student_name,
#                 'grades': [grade['grade']]
#             })

#     return collected_grades


# getAllStudentGrades(['b', 'a'], all_grades)

# Trace
# all_grades = [
#     {'student': 'a', 'grade': 90}, 
#     {'student': 'b', 'grade': 80}, 
#     {'student': 'a', 'grade': 95}, *
# ]
# collected_grades = [
#     {
#         'student': a,
#         'grades': [90, 95]
#     },
#     {
#         'student': b,
#         'grades': [80]
#     }
# ]
# student_name = a
# found_student = True
# 
# ===============================================================

# PART 2, STRATEGY 2

#  Summary: For each student in `students`, collect all grades in `all_grades`.


all_grades = [
    {'student': 'a', 'grade': 90},
    {'student': 'b', 'grade': 80},
    {'student': 'a', 'grade': 95},
]

def get_all_student_grades(students, all_grades):
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

print(get_all_student_grades(['b', 'a'], all_grades))
print(get_all_student_grades(['a', 'b'], all_grades))

# Time complexity

#  Space complexity








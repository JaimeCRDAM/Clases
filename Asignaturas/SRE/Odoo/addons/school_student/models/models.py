# -*- coding: utf-8 -*-

from odoo import models, fields, api
from odoo import _
from odoo.exceptions import Warning, ValidationError
import secrets
import re
import logging

_logger = logging.getLogger(__name__)


class student(models.Model):
    _name = 'school_student.student'
    _description = 'school_student.student'
    name = fields.Char(string='Nombre', readonly=False, required=True, help='Introduzca el nombre')
    # password = fields.Char(default=lambda p: secrets.token_urlsafe(12))
    birth_year = fields.Integer()
    dni = fields.Char(string="DNI")
    description = fields.Text()
    inscription_date = fields.Date()
    last_login = fields.Datetime()
    is_student = fields.Boolean()
    photo = fields.Image(max_width=200, max_height=200)
    classroom = fields.Many2one('school_student.classroom', ondelete='set null')
    teachers = fields.Many2many('school_student.teacher', related='classroom.teachers', readonly=True)
    state = fields.Selection([("1", "Matriculado"), ("2", "Estudiante"), ("3", "Ex-Estudiante")], default="1")

    # @api.depends('name')
    # def _get_password(self):
    #     for student in self:
    #         student.password = secrets.token_urlsafe(12)
    #         _logger.warning('Este es el warning propio ' + str(student))
    def _get_password(self):
        _logger.warning('Este es el warning propio ' + str(student))
        return secrets.token_urlsafe(12)

    password = fields.Char(default=_get_password)

    ###@api.constrains('dni')
    # def _check_dni(self):
    #   regex = re.compile('^[0-9]{8}[a-z]\Z', re.I)
    #   for student in self:
    #       if regex.match(student.dni):
    #           _logger.info('DNI CORRECTO')
    #       else:
    #           raise ValidationError('Formato del DNI incorrecto')
    #
    # _sql_constraints = [('dni_uniq', 'unique(dni)', 'DNI repetido.')]
    ###


class classroom(models.Model):
    _name = 'school_student.classroom'
    _description = 'school_student.classroom'

    name = fields.Char(string='Nombre', readonly=False, required=True, help='Introduzca el nombre')
    students = fields.One2many('school_student.student', 'classroom')
    teachers = fields.Many2many(comodel_name='school_student.teacher',
                                relation="teachers_classrooms",
                                column1='classroom_id',
                                coumnn2='teacher_id')

    teachers_last_year = fields.Many2one(comodel_name='school_student.teacher',
                                         relation="teachers_classroom_ly_apuntes",
                                         column1='classroom_id',
                                         column2='teacher_id')
    coordinator = fields.Many2one('school_student.teacher', compute='_get_cordinador')

    def _get_cordinador(self):
        for classroom in self:
            if len(classroom.teachers) > 0:
                classroom.coordinator = classroom.teachers[0].id
            else:
                classroom.coordinator = None


class teacher(models.Model):
    _name = 'school_student.teacher'
    _description = 'school_student.teacher'

    name = fields.Char(string='Nombre', readonly=False, required=True, help='Introduzca el nombre')
    classrooms = fields.Many2many(comodel_name='school_student.classroom',
                                  relation='teachers_classroom',
                                  column1='teacher_id',
                                  coumn2='classroom_id')

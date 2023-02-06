# -*- coding: utf-8 -*-

from odoo import models, fields, api


class school(models.Model):
 _name = 'school_apuntes.school'
 _description = 'school_apuntes.school'

 name = fields.Char()


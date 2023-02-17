# -*- coding: utf-8 -*-

from odoo import models, fields, api
import datetime

class person(models.Model):
    _name = 'person.person'
    _description = 'person.person'

    name = fields.Char()
    dni = fields.Char()
    foto = fields.Char()


class dietista(models.Model):
    _name = 'nutri.dietista'
    _description = 'nutri.nutri'
    _inherit = 'person.person'

    especialidad = fields.Char()

class nutricionista(models.Model):
    _name = 'nutri.nutricionista'
    _description = 'nutri.nutri'
    _inherit = 'person.person'

    especialidad = fields.Char()

class paciente(models.Model):
    _name = 'nutri.paciente'
    _description = 'nutri.paciente'
    _inherit = 'person.person'

    historial = fields.Char()
    consultas = fields.Char()
    dietista = fields.Many2one('nutri.dietista', string="Dietista")
    nutricionista = fields.Many2one('nutri.nutricionista', string="Nutricionista")

class dieta(models.Model):
    _name = 'nutri.dieta'
    _description = 'nutri.dieta'

    name = fields.Char()
    paciente = fields.One2many(comodel_name ='nutri.paciente', string="Paciente", inverse_name="dni")
    nutricionista = fields.Many2one('nutri.nutricionista', string="Nutricionista")
    descripcion = fields.Char()
    fecha = fields.Date(default=datetime.date.today())

class dieta_revision(models.Model):
    _name = 'nutri.dieta_revision'
    _description = 'nutri.dieta_revision'

    dieta = fields.Many2one('nutri.dieta', string="Dieta")
    paciente = fields.Many2one(comodel_name ='nutri.paciente', string="Paciente", inverse_name="dni")
    nutricionista = fields.Many2one('nutri.nutricionista', string="Nutricionista")
    comentarios = fields.Char()
    fecha = fields.Date(default=datetime.date.today())
    hora = fields.Char()
    peso = fields.Char()

class taller(models.Model):
    _name = 'nutri.taller'
    _description = 'nutri.taller'

    nutricionista = fields.Many2one('nutri.nutricionista', string="Nutricionista")
    pacientes = fields.One2many(comodel_name ='nutri.paciente', string="Paciente", inverse_name="dni")
    link = fields.Char()
    fecha = fields.Date()
    hora = fields.Char()
    tema = fields.Char()


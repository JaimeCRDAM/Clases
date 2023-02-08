# -*- coding: utf-8 -*-

from odoo import models, fields, api


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

class dieta(models.Model):
    _name = 'nutri.dieta'
    _description = 'nutri.dieta'

    paciente = fields.One2many(comodel_name ='nutri.paciente', string="Paciente", inverse_name="dni")
    nutricionista = fields.Many2one('nutri.nutricionista', string="Nutricionista")
    descripcion = fields.Char()
    fecha = fields.Date()

class dieta_revision(models.Model):
    _name = 'nutri.dieta_revision'
    _description = 'nutri.dieta_revision'

    dieta = fields.Many2one('nutri.dieta', string="Dieta")
    comentarios = fields.Char()
    fecha = fields.Date()
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


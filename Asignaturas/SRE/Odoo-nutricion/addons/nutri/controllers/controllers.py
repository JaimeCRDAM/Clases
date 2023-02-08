# -*- coding: utf-8 -*-
# from odoo import http


# class Nutri(http.Controller):
#     @http.route('/nutri/nutri', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/nutri/nutri/objects', auth='public')
#     def list(self, **kw):
#         return http.request.render('nutri.listing', {
#             'root': '/nutri/nutri',
#             'objects': http.request.env['nutri.nutri'].search([]),
#         })

#     @http.route('/nutri/nutri/objects/<model("nutri.nutri"):obj>', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('nutri.object', {
#             'object': obj
#         })

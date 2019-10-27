$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/resources/features/ConsultarColegiosEnUsuario.feature");
formatter.feature({
  "line": 1,
  "name": "Consulta Anidada",
  "description": "",
  "id": "consulta-anidada",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "Consultar usuarios que pertenecen a algun colegio",
  "description": "",
  "id": "consulta-anidada;consultar-usuarios-que-pertenecen-a-algun-colegio",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "que tenemos los servicios de consulta colegio y usuario",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "consultemos la relacion entre usuario colegio",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "se mostraran los usuarios relacionados con los colegios",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitioon.queTenemosLosServiciosDeConsultaColegioYUsuario()"
});
formatter.result({
  "duration": 2422319200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitioon.consultemosLaRelacionEntreUsuarioColegio()"
});
formatter.result({
  "duration": 165431211700,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinitioon.seMostraranLosUsuariosRelacionadosConLosColegios()"
});
formatter.result({
  "duration": 20947748100,
  "status": "passed"
});
});
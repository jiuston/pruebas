Feature: PersonasController
  Scenario: getPersonas
    Given tengo estas personas
      | id_persona| | nombre | | apellidos | | ciudad    |
      | "1"         | | Miguel | | Rodriguez | | Calahorra |
      | "2"         | | Jesus  | | Puente    | | Logronio  |

   # When llamo a /personas
   # Then  debo recibir un codigo 200
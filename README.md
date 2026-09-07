# 📇 Agenda Telefónica — Hackathon Bootcamp

## 👥 Equipo
Proyecto desarrollado por un equipo de **6 personas** durante el segundo hackathon del bootcamp.

Integrantes:
- Luis Angel 
- Homar de Jesús Carmona
- Carlos Alfredo Franco Ordoñez
- Jose
- Diana Cruz Delgado
- Jessica Angeles Resendiz Arroyo


---



## 🧩 Misión

Crear un sistema que permita gestionar una agenda telefónica, teniendo en cuenta las siguientes indicaciones:

- Un contacto está definido por un **nombre** y un **teléfono** (no es necesario validar el formato).
- Un contacto es **igual** a otro cuando sus **nombres son iguales**.
- Una agenda de contactos está formada por un **conjunto de contactos** (a definir qué tipo de estructura es la más adecuada).
- La agenda se podrá crear de **dos formas**: indicando nosotros el tamaño, o con un **tamaño por defecto (10)**.

---

## ⚙️ Requerimientos funcionales

El sistema debe exponer, mediante un menú por consola, las siguientes operaciones sobre la agenda:

1. **Añadir un contacto** — agrega un contacto a la agenda. No se pueden añadir más contactos si la agenda está llena. No se pueden duplicar contactos con el mismo nombre, aunque tengan distinto teléfono. El sistema debe indicar por pantalla si la operación fue exitosa o no.
2. **Comprobar existencia de un contacto** — indica si un contacto pasado como parámetro ya existe en la agenda.
3. **Listar contactos** — muestra todos los contactos almacenados en la agenda.
4. **Buscar contacto por nombre** — dado un nombre, busca el contacto correspondiente y muestra su teléfono.
5. **Eliminar un contacto** — elimina un contacto de la agenda e indica por pantalla si la eliminación fue exitosa o no.
6. **Comprobar si la agenda está llena** — indica si ya no hay espacio disponible en la agenda.
7. **Consultar espacios libres** — indica cuántos contactos más se pueden ingresar en la agenda.

---

## 📏 Reglas de negocio

- No se permiten **nombres duplicados** en la agenda, sin importar si el teléfono es distinto.
- La igualdad entre dos contactos se determina **exclusivamente por el nombre**.
- La agenda tiene un **tamaño máximo**, definido al momento de crearla (explícito o por defecto = 10).
- No se realiza validación del formato de nombre ni de teléfono.

---

## 🛠️ Entorno de trabajo (fase de hackathon)

- **JDK 17 o 21**
- **IntelliJ IDEA** (Community)
- **Maven** (integrado en IntelliJ)
- **Git / GitHub** para el control de versiones


---

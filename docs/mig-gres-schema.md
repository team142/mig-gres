# Mig-gres Schema

Below we will describe mig-gres schema. This will describe changes to a database in this format. This will allow for changes to be made against another database in the future. THis will help in migrating changes between environments.

## Folder / Filename convention

An environment variable called `MIG_GRES_PATH` will be used to find out where the files are stored. 
The settings for the app will be stored in this folder.
Changes made against a database will be stored a sub-directory `database/$DATABASE_NAME$/`.

## Connections

A database connection consists of the following:

- name: a unique name. Must be the same as the filename.
- from: name of another image to inherit fields from.
- project: friendly name for users to identify different projects.
- environment: dev, test, qa, test-a2e01f, etc.
- host: yup
- port: yeah
- username: ahuh
- password: doh




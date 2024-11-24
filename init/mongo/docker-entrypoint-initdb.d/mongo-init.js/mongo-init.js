print('START');

db = db.getSiblingDB('product-service');

db.crateUser(
    {
        user: 'admin',
        pwd: 'password',
        roles: [{roles: 'readWrite', db: 'product-service'}]
    }
);

db.createCollection('user');


print('END');
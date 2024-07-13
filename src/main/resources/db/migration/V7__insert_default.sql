-- Default pizzeria
INSERT INTO public.pizzeria (id,name,phone,email,login,"password",street,neighborhood,zip_code,"number",complement,city,state,active,deleted_at) VALUES
                            ('8d2c5b50-6812-4439-a7b3-fa510f0c1352','Big Pizza','4632240102','bigpizza@gmail.com','big','123','Avenida Tupi','Centro','85504000','123','Casa','Pato Branco','PR',true,NULL);


-- Default ingredients por pizzeria
INSERT INTO public.ingredient (id,pizzeria_id,name,description,price,measurement_unit,quantity) VALUES
                              ('29554bf5-8e6a-4ca7-9417-88385cf3fdd0','8d2c5b50-6812-4439-a7b3-fa510f0c1352','Cebola','Nacional',1.99,'KG',90.00),
                              ('e00e24b5-bd7f-40af-b2cb-eea3d89f6793','8d2c5b50-6812-4439-a7b3-fa510f0c1352','Calabresa','Miolar',19.90,'KG',50.00),
                              ('5edb843b-8544-445f-8316-a456b0c62c3b','8d2c5b50-6812-4439-a7b3-fa510f0c1352','Milho','Quero',1.99,'UN',90.00),
                              ('2d200979-1c1e-4bc7-b62b-5d055949c55d','8d2c5b50-6812-4439-a7b3-fa510f0c1352','Molho','Elefante',1.99,'LT',100.00);

-- Default pizzas
INSERT INTO public.pizza (id,pizzeria_id,name,price,active,deleted_at) VALUES
                         ('3667f860-dc4a-4ff1-8684-4966083972ab','8d2c5b50-6812-4439-a7b3-fa510f0c1352','Calabresa',59.90,true,NULL),
                         ('8a4a758e-73a1-4b0b-9fad-452723539654','8d2c5b50-6812-4439-a7b3-fa510f0c1352','Moda da casa',39.90,true,NULL);

-- Default pizza ingredients
INSERT INTO public.pizza_ingredient (id,pizzeria_id,pizza_id,ingredient_id,quantity) VALUES
                                    ('9a0d2e94-84ce-4a02-bb6f-de359df4bd77','8d2c5b50-6812-4439-a7b3-fa510f0c1352','3667f860-dc4a-4ff1-8684-4966083972ab','29554bf5-8e6a-4ca7-9417-88385cf3fdd0',2.00),
                                    ('97891da9-7719-40c2-ad2c-dd4152226ce2','8d2c5b50-6812-4439-a7b3-fa510f0c1352','3667f860-dc4a-4ff1-8684-4966083972ab','e00e24b5-bd7f-40af-b2cb-eea3d89f6793',3.00),
                                    ('93c1b28f-260f-4728-aa14-8df373525e70','8d2c5b50-6812-4439-a7b3-fa510f0c1352','8a4a758e-73a1-4b0b-9fad-452723539654','29554bf5-8e6a-4ca7-9417-88385cf3fdd0',1.00),
                                    ('e01e60b9-dc6a-4d61-aeb0-975d4d58111c','8d2c5b50-6812-4439-a7b3-fa510f0c1352','8a4a758e-73a1-4b0b-9fad-452723539654','e00e24b5-bd7f-40af-b2cb-eea3d89f6793',2.00),
                                    ('1d73894d-4065-497b-8a59-52e5ff829e9b','8d2c5b50-6812-4439-a7b3-fa510f0c1352','8a4a758e-73a1-4b0b-9fad-452723539654','5edb843b-8544-445f-8316-a456b0c62c3b',1.00),
                                    ('27b281db-bc70-4293-9bd9-73d622c43249','8d2c5b50-6812-4439-a7b3-fa510f0c1352','8a4a758e-73a1-4b0b-9fad-452723539654','2d200979-1c1e-4bc7-b62b-5d055949c55d',2.00);

drop table prescription;
drop table medicalrecord;
drop table invoice;
drop table appointment;

drop table medicine;
drop table admin;
drop table doctor;
drop table reception;
drop table patient;



select * from Reception;
select * from Patient;
select * from Admin;
select * from Doctor;
select * from Appointment;
select * from Prescription;
select * from invoice;
select * from MedicalRecord;
select * from Medicine;

delete from Reception;
delete from Patient;
delete from Admin;
delete from Doctor;
delete from Appointment;
delete from Prescription;
delete from invoice;
delete from MedicalRecord where record_id=29;
delete from Medicine;


CREATE TABLE Admin (
    admin_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    admin_name VARCHAR(20),
    admin_password VARCHAR(100),  
    admin_contact_no VARCHAR(20),
    admin_address VARCHAR(100)
);

CREATE TABLE Doctor (
    doctor_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    doctor_name VARCHAR(50),
    doctor_password VARCHAR(100),  
    doctor_gender VARCHAR(10),
    doctor_qualification VARCHAR(50),  
    doctor_specialization VARCHAR(50),
    doctor_contact_no VARCHAR(20),
    doctor_address VARCHAR(100),
    doctor_email VARCHAR(50),  
    year_of_experience INT,
    consultation_fee VARCHAR(50),
    doctor_image VARCHAR (255),
    is_confirmed INT
);

CREATE TABLE Reception (
    reception_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    reception_name VARCHAR(50),
    reception_password VARCHAR(100),  
    reception_address VARCHAR(100),
    reception_gender VARCHAR(10),
    reception_birth_date  DATE,
    is_confirmed INT
);

CREATE TABLE Patient (
    patient_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    patient_name VARCHAR(50),
    patient_password VARCHAR(100),  
    patient_gender VARCHAR(20),
    patient_birth_date DATE, 
    patient_address VARCHAR(100),
    patient_contact_no VARCHAR(20)
    
);
CREATE TABLE Medicine (
    medicine_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    medicine_name VARCHAR(100),
    brand VARCHAR(50),
    unit VARCHAR(20),
    quantity INT,
    unit_price INT,
    expiration_date DATE 
);

CREATE TABLE Appointment (
    appointment_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    appointment_date DATE,
    patient_id INT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    status VARCHAR(50),
    reception_id INT,
    FOREIGN KEY (reception_id) REFERENCES Reception(reception_id),
    appointment_time VARCHAR(30)

);

CREATE TABLE MedicalRecord (
    record_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    visit_date DATE,
    diagnosis VARCHAR(200),
    treatment VARCHAR(200),
    follow_up_date DATE,
    allergic VARCHAR(50)
);


CREATE TABLE Prescription (
    prescription_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    doctor_id INT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    medicine_id INT,
    FOREIGN KEY (medicine_id) REFERENCES Medicine(medicine_id),
    prescription_date DATE,
    frequency int,
    duration int,
    notes VARCHAR(100)
);

ALTER TABLE Prescription CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

CREATE TABLE Invoice (
    invoice_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    patient_name VARCHAR(50),
    doctor_name VARCHAR(50),
 	prescription_date DATE,
 	consultation_fee VARCHAR(50),
    total_cost DOUBLE
);



insert into Patient values (null,'Khin','123','23','Female','2023/12/23','ygn','12334566');

INSERT INTO Admin VALUES (null,'Health Hub','Health123','09784500500','Hlaing Township');


INSERT INTO Doctor VALUES (null,'Dr.Hnin Myat San','Doctor123','Female','M.B.B.S(mdy),M.Med.Sc[Int.Med]','Heart','09402487884','North-Okkalapa Township Yangon','hninmyatsan@gmail.com',5,'25000 Kyats');
INSERT INTO Doctor VALUES (null,'Dr.Hla Aung','Doctor123','Male','M.B.B.S(ygn),M.R.C.P(London)','General','09426180901','Insein Township Yangon','hlaaung@gmail.com',5,'20000 Kyats');
INSERT INTO Doctor VALUES (null,'Dr.Sein War War Sein','Doctor123','Female','M.B.B.S(ygn),M.R.C.P(UK)','Cancer','09679180720','Mayangone Township Yangon','seinwarwarsein@gmail.com',5,'30000 Kyats');
INSERT INTO Doctor VALUES (null,'Professor U Ko Ko','Doctor123','Male','M.B.B.S(mdy),M.Med.Sc[Int.Med]','Diabetes','09425956687','Sule Township Yangon','ukoko@gmail.com',10,'20000 Kyats');
INSERT INTO Doctor VALUES (null,'Professor Khine Khine Zaw','Doctor123','Female','M.B.B.S(ygn),Ph.D(Dermatoloty)','Skin','09267243852','SanChaung Township Yangon','khinekhinezaw@gmail.com',8,'15000 Kyats');

INSERT INTO Medicine VALUES (null,'Zyrtec', 'GlaxoSmithkline','Tablet 10Mg', 250, 250,'2026/7/25');
INSERT INTO Medicine VALUES (null,'SolmuxBooncho', 'UnitedPharma','Injection 5Ml', 300, 150,'2026/4/1');
INSERT INTO Medicine VALUES (null,'Flixonase', 'GlaxoSmithkline','Spray 100Mg', 300, 1500,'2027/10/5');
INSERT INTO Medicine VALUES (null,'Ascoril Expectorant', 'Glenmark','Injection 10Ml', 250, 1700,'2027/7/7');
INSERT INTO Medicine VALUES (null,'Piriton Expectorant', 'GlaxoSmithkline','Injection 5Ml', 350, 1500,'2025/12/31');
INSERT INTO Medicine VALUES (null,'Relenza', 'GlaxoSmithkline','Tablet 5Mg', 500, 200,'2026/12/31');
INSERT INTO Medicine VALUES (null,'Plasmotrim', 'Acino Switzerland','Tablet 50Ml', 350, 1500,'2026/5/7');

INSERT INTO Medicine VALUES (null,'GenoZyme', 'Geno','Tablet 100Mg', 200, 1000,'2027/9/8');
INSERT INTO Medicine VALUES (null,'Strocain', 'Eisai','Tablet 250Mg', 300, 500,'2027/1/18');
INSERT INTO Medicine VALUES (null,'Konimag', 'PT Konimex','Injection 7Ml', 150, 500,'2026/7/3');

INSERT INTO Medicine VALUES (null,'Paracetamol', 'Paracap','Tablet 250Mg', 300, 150,'2025/6/1');
INSERT INTO Medicine VALUES (null,'Paracetamol', 'Para_Denk','Tablet 500Mg', 350, 200,'2025/6/25');
INSERT INTO Medicine VALUES (null,'Amoxicillin', 'Reichamox','Tablet 250Mg', 400, 200,'2026/8/10');
INSERT INTO Medicine VALUES (null,'Nepa', 'Beximco','Tablet 500Mg', 450, 200,'2026/2/3');
INSERT INTO Medicine VALUES (null,'Ultracet', 'Janssen_Cilag','Tablet 250Mg', 500, 250,'2027/8/9');
INSERT INTO Medicine VALUES (null,'Etoshine', 'Sun Pharma','Tablet 500Mg', 250, 200,'2026/12/17');
INSERT INTO Medicine VALUES (null,'Dolfenal', 'United Pharma','Tablet 250Mg', 1000, 250,'2026/7/1');
INSERT INTO Medicine VALUES (null,'Remopain', 'Dexa Medica','Injection 10Ml', 350, 3000,'2026/5/11');

INSERT INTO Medicine VALUES (null,'Vastarel MR', 'Servier','Tablet 250Mg', 1000, 2000,'2026/9/12');
INSERT INTO Medicine VALUES (null,'Taverin', 'Beximco','Tablet 250Mg', 1000, 1500,'2027/8/7');
INSERT INTO Medicine VALUES (null,'Stamlo', 'Reddys','Tablet 10Mg', 1000, 3000,'2027/9/14');
INSERT INTO Medicine VALUES (null,'Aspidogrel', 'Sun Pharma','Tablet 250Mg', 700, 2500,'2025/3/10');
INSERT INTO Medicine VALUES (null,'Clopidogrel', 'Plavix','Tablet 250Mg', 700, 3000,'2027/7/11');
INSERT INTO Medicine VALUES (null,'Metpure', 'Emcure Pharma','Tablet 10Mg', 750, 1000,'2026/10/21');
INSERT INTO Medicine VALUES (null,'Cardisafe', 'Apothecary','Tablet 50Mg', 700, 2000,'2027/9/17');
INSERT INTO Medicine VALUES (null,'Cordarone', 'Sanofi Avrentis','Tablet 250Mg', 650, 1500,'2026/9/27');
INSERT INTO Medicine VALUES (null,'Cardiopril', 'Reddys','Tablet 5Mg', 500, 1000,'2026/1/27');
INSERT INTO Medicine VALUES (null,'Carvedilol', 'Dilatrend', 'Tablet 10Mg',500,150, '2025/12/21');
INSERT INTO Medicine VALUES (null,'Trarceva', 'Roche','Tablet 150Mg', 550, 200,'2026/5/3');
INSERT INTO Medicine VALUES (null,'Unitaxel', 'KoreaUnited Pharm','Injection 5Ml', 200, 10000,'2025/3/9');
INSERT INTO Medicine VALUES (null,'Osetron', 'Reddys','Tablet 10Mg', 250, 250,'2025/2/18');
INSERT INTO Medicine VALUES (null,'Cisplatin','Platinex','Injection 50ML',50,5000,'2027/7/25');
INSERT INTO Medicine VALUES (null,'Paclitaxel','Ontaxel','Injection 50ML',50,5500,'2028/5/7');
INSERT INTO Medicine VALUES (null,'Afinitor','Novartis','Tablet 10Mg',300,3500,'2026/6/25');
INSERT INTO Medicine VALUES (null,'Durvalumab','Imfinzi','Tablet 120Mg',200,3500,'2028/5/3');
INSERT INTO Medicine VALUES (null,'Regorafenib','Stivarga','Tablet 80Mg',200,6000,'2027/9/17');
INSERT INTO Medicine VALUES (null,'Oxaliplatin','Avastin','Injection 10ML',50,8000,'2026/5/3');
INSERT INTO Medicine VALUES (null,'Docetaxel','Docetero','Injection 8ML',50,4000,'2027/2/18');
INSERT INTO Medicine VALUES (null,'Doxorubicin Hydrochloride','Doxotero','Injection 25ML',50, 50000,'2025/8/7');
INSERT INTO Medicine VALUES (null,'Alpelisib','Pivikto','Tablet 150Mg',100,8000,'2027/1/18');
INSERT INTO Medicine VALUES (null,'Aredia','Pamidronate','Injection 15ML',50,75000,'2027/8/9');
INSERT INTO Medicine VALUES (null,'Carboplatin','Kemocare','Injection 15ML',50,45000,'2028/5/7');

INSERT INTO Medicine VALUES (null,'Metformin Hydrochloride','Metformin','Tablet 500Mg',500,590,'2026/5/6');
INSERT INTO Medicine VALUES (null,'Alpha Glucosidose','Voglibose','Tablet 0.3Mg',250,690,'2026/3/1');
INSERT INTO Medicine VALUES (null,'Bigsens XR','Zydus Codila','Tablet 500Mg',300,100,'2025/5/2');
INSERT INTO Medicine VALUES (null,'Insulin','Insunova R','Injection 10ML',100,24800,'2026/1/13');
INSERT INTO Medicine VALUES (null,'Trevia Sitagliptin','Trevia','Tablet 50Mg',150,3400,'2025/7/20');
INSERT INTO Medicine VALUES (null,'Metformic HCL','Pacformin','Tablet 500Mg',200,590,'2026/3/8');
INSERT INTO Medicine VALUES (null,'Pacific Pharmaceuficals','Daglu','Tablet 40Mg',270,120,'2025/10/11');
INSERT INTO Medicine VALUES (null,'Glimepiride','Getryl','Tablet 4Mg',300,425,'2026/4/25');
INSERT INTO Medicine VALUES (null,'Metformin Hydrochloride','Glycomet','Tablet 100Mg',350,175,'2025/12/30');
INSERT INTO Medicine VALUES (null,'Pramlintide Acefafe','Amylin','Injection 1Mg',100,50000,'2026/8/2');

INSERT INTO Medicine VALUES (null,'Nifedipine','Adalat Nidipine','Tablet 25Mg',100,400,'2026/5/3');
INSERT INTO Medicine VALUES (null,'Repace','Sun Pharma','Tablet 50Mg',100,400,'2025/2/18');
INSERT INTO Medicine VALUES (null,'Preterax','Servier','Tablet 10Mg',75,500,'2025/8/7');
INSERT INTO Medicine VALUES (null,'Prolomet','Sun Pharma','Tablet 100Mg',120,600,'2025/6/1');

INSERT INTO Medicine VALUES (null,'Silkron','Sun Pharma','Tube 10g',200,4250,'2026/5/7');
INSERT INTO Medicine VALUES (null,'Betamethasone','Celestone','Cream',150,1000,'2029/10/9');
INSERT INTO Medicine VALUES (null,'Hydroquinone','Lustra','Cream',100,10000,'2027/9/8');
INSERT INTO Medicine VALUES (null,'Salicyclic Acid','Compound W','Cream',75,11000,'2028/6/28');
INSERT INTO Medicine VALUES (null,'Triamcinolone','KenalogIV','Cream',100,41000,'2029/9/10');
INSERT INTO Medicine VALUES (null,'Urea','Carmol10','Cream',75,60000,'2028/2/11');
INSERT INTO Medicine VALUES (null,'Luxiq','Celestone','Cream',250,4000,'2027/7/12');
INSERT INTO Medicine VALUES (null,'Diprolene','Beclate','Cream',200,94000,'2029/9/27');
INSERT INTO Medicine VALUES (null,'Carbilloxamine','Nicolan','Tablet 25Mg',50,700,'2025/9/21');
INSERT INTO Medicine VALUES (null,'Doxylamine','Decapryn','Tablet 75Mg',75,650,'2026/4/30');
INSERT INTO Medicine VALUES (null,'Pyrilamine','R-Tannate','Liquid 50ML',60,20000,'2028/7/13');
INSERT INTO Medicine VALUES (null,'Bromphen', 'Iramine','Tablet 25Mg',90,600,'2027/9/6');
INSERT INTO Medicine VALUES (null,'Cyclizine','Valoid','Tablet 25Mg',100,900,'2026/5/9');
INSERT INTO Medicine VALUES (null,'Ebastine','Ebast','Tablet 75Mg',95,500,'2027/5/10');

SELECT
    p.patient_name,
    d.doctor_name,
    pr.prescription_date,
    d.consultation_fee,
    SUM(m.unit_price * pr.frequency * pr.duration) + d.consultation_fee AS total_cost
FROM
    Prescription pr
JOIN Patient p ON pr.patient_id = p.patient_id
JOIN Doctor d ON pr.doctor_id = d.doctor_id
JOIN Medicine m ON pr.medicine_id = m.medicine_id
WHERE
    p.patient_id = 1
GROUP BY
    p.patient_name,
    d.doctor_name,
    pr.prescription_date,
    d.consultation_fee
ORDER BY
    p.patient_name;

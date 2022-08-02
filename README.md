# Tugas Akhir Mata Kuliah Pemrograman Visual

### Database
db_host = 103.214.112.18 \
db_username = azisnauf_ta_basdat \
db_name = azisnauf_ta_basdat \
db_password = KVk^Ybp^jjdh

### Query Database

##### Tabel Pasien
```sql
create table pasien (
    id_pasien int(11) primary key auto_increment ,
    nama varchar(100) not null ,
    jenis_kelamin varchar(1) not null ,
    alamat text not null ,
    umur char(11) not null ,
    deleted_at timestamp
);
```

##### Tabel Dokter
```sql
create table dokter (
    id_dokter int(11) primary key auto_increment ,
    nama_dokter varchar(100) not null ,
    alamat_dokter text not null ,
    spesialis varchar(50) not null ,
    deleted_at timestamp
);
```

##### Tabel Tindakan
```sql
create table tindakan (
    id_tindakan int(11) primary key auto_increment ,
    nama varchar(60) not null ,
    harga bigint(20) not null ,
    deleted_at timestamp
);
```

##### Tabel Obat
```sql
create table obat (
    id_obat int(11) primary key auto_increment ,
    nama_obat varchar(100) not null ,
    harga bigint(20) not null ,
    tanggal_kadaluarsa date not null ,
    deleted_at timestamp
);
```

##### Tabel Pemeriksaan
```sql
create table pemeriksaan (
    no_nota int(11) primary key auto_increment ,
    id_pasien int(11) ,
    id_dokter int(11) ,
    total bigint(20) not null ,
    tanggal date not null ,
    tinggi_badan float(4, 2) ,
    berat_badan float(3, 2) ,
    sistolik int(3) ,
    diastolik int(3) ,
    deleted_at timestamp ,

    foreign key (id_pasien) references pasien(id_pasien) on update cascade on delete cascade ,
    foreign key (id_dokter) references dokter(id_dokter) on update cascade on delete cascade
);
```

##### Tabel Tindak
```sql
create table tindak (
    no_nota int(11) ,
    id_tindakan int(11) ,
    subtotal bigint(20) not null ,
    deleted_at timestamp ,

    foreign key (no_nota) references pemeriksaan(no_nota) on update cascade on delete cascade ,
    foreign key (id_tindakan) references tindakan(id_tindakan) on update cascade on delete cascade
);
```

##### Tabel Tercatat
```sql
create table tercatat (
    no_nota int(11) ,
    id_obat int(6) ,
    subtotal bigint(20) not null ,
    deleted_at timestamp ,

    foreign key (no_nota) references pemeriksaan(no_nota) on update cascade on delete cascade ,
    foreign key (id_obat) references obat(id_obat) on update cascade on delete cascade
);
```

### Catatan
Jangan lupa untuk
```git
git pull
```
sebelum
```
git push
```

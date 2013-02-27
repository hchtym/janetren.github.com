create view ykt_cur.v_photo (cut_id,photo) as
(select c.cut_id,p.photo from ykt_cur.t_cif_customer c,ykt_cur.t_cif_photo p where c.stuemp_no = p.stuemp_no) 
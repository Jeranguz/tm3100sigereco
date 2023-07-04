package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.PrivilegioTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T21:12:41", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PerfilTb.class)
public class PerfilTb_ { 

    public static volatile SingularAttribute<PerfilTb, String> descripcion;
    public static volatile SingularAttribute<PerfilTb, String> tipoUsuario;
    public static volatile ListAttribute<PerfilTb, PrivilegioTb> privilegioTbList;
    public static volatile SingularAttribute<PerfilTb, Integer> id;

}
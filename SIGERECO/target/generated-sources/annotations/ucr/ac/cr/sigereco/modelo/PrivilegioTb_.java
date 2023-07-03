package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.PerfilTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T11:55:49", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(PrivilegioTb.class)
public class PrivilegioTb_ { 

    public static volatile SingularAttribute<PrivilegioTb, String> descripcion;
    public static volatile ListAttribute<PrivilegioTb, PerfilTb> perfilTbList;
    public static volatile SingularAttribute<PrivilegioTb, Integer> id;
    public static volatile SingularAttribute<PrivilegioTb, String> nombre;

}
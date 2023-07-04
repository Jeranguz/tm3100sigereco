package ucr.ac.cr.sigereco.modelo;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaTb;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T21:12:41", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(CategoriaTb.class)
public class CategoriaTb_ { 

    public static volatile SingularAttribute<CategoriaTb, Integer> id;
    public static volatile SingularAttribute<CategoriaTb, String> nombre;
    public static volatile ListAttribute<CategoriaTb, RecetaTb> recetaTbList;

}
package ucr.ac.cr.sigereco.modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasReceta1TbPK;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-02T23:36:38", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(UsuarioHasReceta1Tb.class)
public class UsuarioHasReceta1Tb_ { 

    public static volatile SingularAttribute<UsuarioHasReceta1Tb, RecetaTb> recetaTb;
    public static volatile SingularAttribute<UsuarioHasReceta1Tb, Date> fechaInicio;
    public static volatile SingularAttribute<UsuarioHasReceta1Tb, UsuarioHasReceta1TbPK> usuarioHasReceta1TbPK;
    public static volatile SingularAttribute<UsuarioHasReceta1Tb, Date> fechaFinal;

}
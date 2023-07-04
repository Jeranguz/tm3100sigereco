package ucr.ac.cr.sigereco.modelo;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import ucr.ac.cr.sigereco.modelo.RecetaTb;
import ucr.ac.cr.sigereco.modelo.UsuarioHasRecetaTbPK;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-07-03T21:12:41", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(UsuarioHasRecetaTb.class)
public class UsuarioHasRecetaTb_ { 

    public static volatile SingularAttribute<UsuarioHasRecetaTb, RecetaTb> recetaTb;
    public static volatile SingularAttribute<UsuarioHasRecetaTb, Date> fecha;
    public static volatile SingularAttribute<UsuarioHasRecetaTb, Integer> numVotos;
    public static volatile SingularAttribute<UsuarioHasRecetaTb, UsuarioHasRecetaTbPK> usuarioHasRecetaTbPK;

}
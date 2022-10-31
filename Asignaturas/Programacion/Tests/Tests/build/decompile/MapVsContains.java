/*
 * Decompiled with CFR 0.150.
 */
package Models;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import org.jetbrains.annotations.NotNull;

@Metadata(mv={1, 7, 1}, k=1, xi=48, d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\fR\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2={"LModels/MapVsContains;", "", "()V", "insuranceArray", "", "", "getInsuranceArray", "()[Ljava/lang/String;", "setInsuranceArray", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "contains", "", "givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect", "map", "Tests"})
public final class MapVsContains {
    @NotNull
    private String[] insuranceArray;

    public MapVsContains() {
        int time;
        int n = 0;
        String[] arrstring = new String[3];
        MapVsContains mapVsContains = this;
        while (n < 3) {
            int n2 = n++;
            arrstring[n2] = this.givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect();
        }
        mapVsContains.insuranceArray = arrstring;
        long timer = System.nanoTime();
        for (time = 0; time < 1000000; ++time) {
            this.contains();
        }
        long l = System.nanoTime() - timer;
        System.out.println(l);
        timer = System.nanoTime();
        for (time = 0; time < 1000000; ++time) {
            this.map();
        }
        l = System.nanoTime() - timer;
        System.out.println(l);
    }

    @NotNull
    public final String[] getInsuranceArray() {
        return this.insuranceArray;
    }

    public final void setInsuranceArray(@NotNull String[] arrstring) {
        Intrinsics.checkNotNullParameter(arrstring, "<set-?>");
        this.insuranceArray = arrstring;
    }

    /*
     * WARNING - void declaration
     */
    public final boolean map() {
        void $this$mapTo$iv$iv;
        String[] $this$map$iv = this.insuranceArray;
        boolean $i$f$map = false;
        String[] arrstring = $this$map$iv;
        Collection destination$iv$iv = new ArrayList($this$map$iv.length);
        boolean $i$f$mapTo = false;
        int n = ((void)$this$mapTo$iv$iv).length;
        for (int i = 0; i < n; ++i) {
            void it;
            void item$iv$iv;
            void var9_9 = item$iv$iv = $this$mapTo$iv$iv[i];
            Collection collection = destination$iv$iv;
            boolean bl = false;
            if (Intrinsics.areEqual(it, this.insuranceArray[Random.Default.nextInt(0, this.insuranceArray.length)])) {
                return true;
            }
            collection.add(Unit.INSTANCE);
        }
        List cfr_ignored_0 = (List)destination$iv$iv;
        return false;
    }

    public final boolean contains() {
        return ArraysKt.contains(this.insuranceArray, this.insuranceArray[Random.Default.nextInt(0, this.insuranceArray.length)]);
    }

    @NotNull
    public final String givenUsingPlainJava_whenGeneratingRandomStringUnbounded_thenCorrect() {
        byte[] array = new byte[10];
        Random.Default.nextBytes(array);
        Charset charset = Charset.forName("UTF-8");
        Intrinsics.checkNotNullExpressionValue(charset, "forName(\"UTF-8\")");
        Charset charset2 = charset;
        String generatedString = new String(array, charset2);
        return generatedString;
    }
}

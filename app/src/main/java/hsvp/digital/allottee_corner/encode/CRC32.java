package hsvp.digital.allottee_corner.encode;

public class CRC32 {

    public static long encode(byte[] source) {
        java.util.zip.CRC32 crc = new java.util.zip.CRC32();
        crc.update(source);
        return crc.getValue();
    }


}

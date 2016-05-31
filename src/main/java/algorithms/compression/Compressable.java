package algorithms.compression;

public interface Compressable {
    Compressed compress(Uncompressed uncompressed);
    Uncompressed uncompress(Compressed compressed);
}
